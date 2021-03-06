/*
 * Copyright 2013 Mark Biciunas
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.agorex.parse;


import org.junit.Before;

import com.agorex.parse.annotation.AnnotationState;
import com.agorex.parse.data.Data;
import com.agorex.parse.data.DataArray;
import com.agorex.parse.data.sql.ConfigurationSql;
import com.agorex.parse.data.sql.DataSql;
import com.agorex.parse.search.TokenRange;
import com.agorex.parse.token.Token;
import com.agorex.parse.token.TokenData;

/**
 * @author mbiciunas
 *
 */
/**
 * @author mbiciunas
 *
 */
public abstract class AbstractTest {

   private transient ParseData parseData;
   private transient DataArray dataArray;
   private transient TokenRange tokenRange;


   /**
    *
    */
   @Before
   public final void setUp() {
      dataArray = new DataSql().getDataArray();
      parseData = new ParseData(ConfigurationSql.getConfiguration());
   }


   /**
    * @return object containing all the parse data
    */
   protected final ParseData getParseData() { return parseData; }


   /**
    * @return set of tokens
    */
   protected final TokenData getToken() { return parseData.getToken(); }


   /**
    * @return annotation state
    */
   protected final AnnotationState getAnnotationState() { return parseData.getAnnotationState(); }


   /**
    * @return number of data objects
    */
   protected final int getDataArraySize() { return dataArray.size(); }


   /**
    * @param index position in the data array
    * @return object containing a statement and correct parsing data for that statement
    */
   protected final Data getDataArrayData(final int index) { return dataArray.getData(index); }


   /**
    * @return set of objects containing a statement and correct parsing data
    */
   protected final DataArray getDataArray() { return dataArray; }


   /**
    * @return range of tokens to be searched
    */
   protected final TokenRange getResultSingleTokenRange() { return tokenRange; }


   /**
    * @param statement text to be tokenized
    */
   protected final void initialize(final String statement) {

      parseData.initialize(statement);

      Token.parse(parseData);

      tokenRange = new TokenRange(0, parseData.getToken().getSize());

   }
}
