package financebatch;

import com.microsoft.sqlserver.jdbc.SQLServerException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.MultiResourceItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import javax.sql.DataSource;
import java.io.IOException;

// Contains the Factories, Jobs, steps "Basically the main program"

@Configuration
@EnableBatchProcessing
public class BatchConfig {

    Logger logger = LoggerFactory.getLogger(BatchConfig.class);

    @Autowired
    public JobBuilderFactory jobBuilderFactory;
    @Autowired
    public StepBuilderFactory stepBuilderFactory;


    @Bean(name = "dataSource")
    public static DataSource dataSource() throws SQLServerException {
        SSDS ssds = new SSDS();
        ssds.getSqlServerDataSource().getConnection();
        return ssds.getSqlServerDataSource() ;
        }

    // multiple resource item reader for funding file allows multiple files to be read in and mapped to a java object.
    @Bean
    public MultiResourceItemReader<FundingPurchaseStatementUpgrade> multiReaderFunding(){
        Resource[]resources = null;
        ResourcePatternResolver patternResolver = new PathMatchingResourcePatternResolver();
        try {
            resources = patternResolver.getResources("file:Z:/Upgrade/Partner_Funding/*.csv");
            for (Resource resource:resources) {
                System.out.print(" file name:"+ resource.getFilename()+"\n");
            }

        } catch (IOException e){
            e.printStackTrace();
        }
        MultiResourceItemReader<FundingPurchaseStatementUpgrade> multiResourceItemReader = new MultiResourceItemReader<>();
        assert resources != null;
        multiResourceItemReader.setResources(resources);
        multiResourceItemReader.setDelegate(csvReader());
        multiResourceItemReader.setStrict(true);
        return multiResourceItemReader;
    }


    @Bean
    public FlatFileItemReader<FundingPurchaseStatementUpgrade> csvReader(){
         final FlatFileItemReader<FundingPurchaseStatementUpgrade> flatFileItemReader = new FlatFileItemReader<>();
         final BeanWrapperFieldSetMapper<FundingPurchaseStatementUpgrade> beanWrapper = new BeanWrapperFieldSetMapper<>();
         final DefaultLineMapper<FundingPurchaseStatementUpgrade> lineMapper = new DefaultLineMapper<>();
         final DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
         lineTokenizer.setDelimiter(",");
         lineTokenizer.setStrict(false);
         lineTokenizer.setQuoteCharacter('"');
         lineTokenizer.setNames("fundingDate","loanId","grossFundingAmount","netFundingAmount",
                 "originationFees","state","finalGrade","ficoOfCustomer","term","purchaseDate",
                "interestRate", "numberOfDaysOfInterest","interimInterest","firstMonthPAndI",
                "serviceFee","totalPurchaseAmount","segment","isSeasoned","marketingFeeDue","allocatedId");

         beanWrapper.setTargetType(FundingPurchaseStatementUpgrade.class);
         lineMapper.setLineTokenizer(lineTokenizer);
         lineMapper.setFieldSetMapper(beanWrapper);

         flatFileItemReader.setLineMapper(lineMapper);
         flatFileItemReader.setLinesToSkip(1);
         return flatFileItemReader;

    }
    @Bean
    public FundingProcessor fundingProcessor(){
        return new FundingProcessor();
    }


    @Bean
    public JdbcBatchItemWriter<FundingPurchaseStatementUpgrade> fundingInsertDB (DataSource dataSource){
        return new JdbcBatchItemWriterBuilder<FundingPurchaseStatementUpgrade>()
                .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
                .sql("INSERT INTO FundingStatement (FundingDate,LoanID,GrossFundingAmount,NetFundingAmount,OriginationFees,State,FinalGrade,FICOofCustomer,Term,PurchaseDate,InterestRate,NumOfDaysInterest,InterimInterest,FirstMoPI,ServiceFee,TotalPurchaseAmount)" +
                        " VALUES (:fundingDate, :loanId, :grossFundingAmount, :netFundingAmount, :originationFees, :state, :finalGrade ,:ficoOfCustomer ,:term, :purchaseDate, :interestRate, :numberOfDaysOfInterest, :interimInterest, :firstMonthPAndI, :serviceFee, :totalPurchaseAmount)")
                .dataSource(dataSource)
                .build();
    }
    // reads in multiple files from a location that are csv and connects them to a java object

    @Bean
    public MultiResourceItemReader<OriginationFeeUpgrade> multiReaderOrigFee(){

        Resource[]resources = null;
        ResourcePatternResolver patternResolver = new PathMatchingResourcePatternResolver();
        try {
            resources = patternResolver.getResources("file:Z:/Upgrade/Origination_Fee/*.csv");
            for (Resource resource:resources) {
                System.out.print("file name:"+ resource.getFilename()+"\n ");
            }

        } catch (IOException e){
            e.printStackTrace();
        }
        MultiResourceItemReader<OriginationFeeUpgrade> multiResourceItemReader = new MultiResourceItemReader<>();
        assert resources != null;
        multiResourceItemReader.setResources(resources);
        multiResourceItemReader.setDelegate(csvReaderOrigFee());
        multiResourceItemReader.setStrict(true);
        return multiResourceItemReader;
    }


    @Bean
    public FlatFileItemReader<OriginationFeeUpgrade> csvReaderOrigFee(){
        final FlatFileItemReader<OriginationFeeUpgrade> flatFileItemReader = new FlatFileItemReader<>();
        final BeanWrapperFieldSetMapper<OriginationFeeUpgrade> beanWrapper = new BeanWrapperFieldSetMapper<>();
        final DefaultLineMapper<OriginationFeeUpgrade> lineMapper = new DefaultLineMapper<>();
        final DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
        lineTokenizer.setQuoteCharacter('"');
        lineTokenizer.setDelimiter(",");
        lineTokenizer.setStrict(false);
        lineTokenizer.setNames("date","originationVolume","cumulativeVolume","designatedAmount","itemCount","perLoanFee",
                "totalOriginationVolume","borrowerOriginationFee","perLoanAmount","designatedAmount1","marketingFeeDue",
                "marketFeeSeasoned");

        beanWrapper.setTargetType(OriginationFeeUpgrade.class);
        lineMapper.setLineTokenizer(lineTokenizer);
        lineMapper.setFieldSetMapper(beanWrapper);

        flatFileItemReader.setLineMapper(lineMapper);
        flatFileItemReader.setLinesToSkip(1);
        return flatFileItemReader;

    }
    @Bean
    public OrigFeeProcessor origFeeProcessor(){
        return new OrigFeeProcessor();
    }


    @Bean
    public JdbcBatchItemWriter<OriginationFeeUpgrade> origFeeInsertDB (DataSource dataSource){
        return new JdbcBatchItemWriterBuilder<OriginationFeeUpgrade>().beanMapped()
                .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
                .sql("INSERT INTO DailyOriginationFee(Date,OriginationVolume,CumulativeVolume," +
                        "DesignatedAmount,ItemCount,PerLoanFee,TotalOriginationVolume,BorrowerOriginationFee" +
                        ",PerLoanAmount,MarketingFeeDue)VALUES(:date,:originationVolume,:cumulativeVolume," +
                        ":designatedAmount,:itemCount,:perLoanFee,:totalOriginationVolume,:borrowerOriginationFee,:perLoanAmount,:marketingFeeDue)")
                .dataSource(dataSource)
                .build();
    }

    @Bean
    public FileMoveTasklet fileMoveTaskletFunding(){

        String pathToArchive = "Z:\\Archive\\Upgrade Inc\\Upgrade Sent Files Archive";
        return new FileMoveTasklet("file:Z:/Upgrade/Partner_Funding/*.csv",pathToArchive);
    }

    @Bean FileMoveTasklet fileMoveTaskletOrigFee(){

        String pathToArchive = "Z:\\FTP\\Archive\\Upgrade Inc\\Upgrade Sent Files Archive";
        return new FileMoveTasklet("file:Z:/Upgrade/Origination_Fee/*.csv" ,pathToArchive);
    }

    @Bean
    // Job that encompasses the two uploads for the upgrade's two csv data files
    //
    public Job importFilesToDB() throws SQLServerException {

        return  jobBuilderFactory.get("importFilesToDB")
                .incrementer(new RunIdIncrementer())
                .flow(step1(fundingInsertDB(dataSource())))
                .next(step2(origFeeInsertDB(dataSource())))
                //.next(step3(fileMoveTaskletFunding()))
                //.next(step4(fileMoveTaskletOrigFee()))
                .end()
                .build();
    }

    // each step is generally composed of 3 tasks reader, processor, and writer. I have tasklet that covers the moving of the
    @Bean
    public Step step1(JdbcBatchItemWriter<FundingPurchaseStatementUpgrade> writer){
        return stepBuilderFactory.get("step1")
                .<FundingPurchaseStatementUpgrade,FundingPurchaseStatementUpgrade>chunk(10)
                .reader(multiReaderFunding())
                .processor(fundingProcessor())
                .writer(writer)
                .build();
    }

    @Bean
    public Step step2(JdbcBatchItemWriter<OriginationFeeUpgrade> writer){
        return stepBuilderFactory.get("step2")
                .<OriginationFeeUpgrade,OriginationFeeUpgrade>chunk(10)
                .reader(multiReaderOrigFee())
                .processor(origFeeProcessor())
                .writer(writer)
                .build();
    }

    @Bean
    public Step step3(@Qualifier("fileMoveTaskletFunding") Tasklet tasklet){
        return stepBuilderFactory.get("step3")
                .tasklet(tasklet)
                .build();
    }

    @Bean
    public Step step4(@Qualifier("fileMoveTaskletOrigFee") Tasklet tasklet){
        return stepBuilderFactory.get("step4")
                .tasklet(tasklet)
                .build();
    }
}
