package financebatch;


import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.batch.item.file.transform.LineTokenizer;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.util.Assert;

public class SkipLastLineMapper<T>implements LineMapper<T>, InitializingBean  {


        private LineTokenizer tokenizer;

        private FieldSetMapper<T> fieldSetMapper;

        @Override
        public T mapLine(String line, int lineNumber) throws Exception {
            if(line.contains(",,,,,,")) return null;
            return fieldSetMapper.mapFieldSet(tokenizer.tokenize(line));
        }

        public void setLineTokenizer(LineTokenizer tokenizer) {
            this.tokenizer = tokenizer;
        }

        public void setFieldSetMapper(FieldSetMapper<T> fieldSetMapper) {
            this.fieldSetMapper = fieldSetMapper;
        }

        @Override
        public void afterPropertiesSet() {
            Assert.notNull(tokenizer, "The LineTokenizer must be set");
            Assert.notNull(fieldSetMapper, "The FieldSetMapper must be set");
        }


    }
