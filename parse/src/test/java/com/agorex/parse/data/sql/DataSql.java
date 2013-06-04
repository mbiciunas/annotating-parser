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
package com.agorex.parse.data.sql;

import com.agorex.parse.data.DataArray;

/**
 * @author mbiciunas
 *
 */
public final class DataSql {

   private final transient DataArray dataArray = new DataArray();


   /**
    *
    */
   public DataSql() {
      dataArray.addData(new DataSqlSimple01().getData());
      dataArray.addData(new DataSqlBracket01().getData());
      dataArray.addData(new DataSqlBracket02().getData());
      dataArray.addData(new DataSqlBracket03().getData());
      dataArray.addData(new DataSqlBracket04().getData());
      dataArray.addData(new DataSqlBracket05().getData());
      dataArray.addData(new DataSqlBracket06().getData());
      dataArray.addData(new DataSqlBracket07().getData());
      dataArray.addData(new DataSqlBracket08().getData());
      dataArray.addData(new DataSqlBracket09().getData());
      dataArray.addData(new DataSqlQuoteSingle01().getData());
      dataArray.addData(new DataSqlQuoteSingle02().getData());
      dataArray.addData(new DataSqlQuoteSingle03().getData());
      dataArray.addData(new DataSqlQuoteSingle04().getData());
      dataArray.addData(new DataSqlQuoteDouble01().getData());
      dataArray.addData(new DataSqlQuoteDouble02().getData());
      dataArray.addData(new DataSqlQuoteDouble03().getData());
      dataArray.addData(new DataSqlQuoteDouble04().getData());
   }


   /**
    * @return set of sql statements to be tested
    */
   public DataArray getDataArray() { return dataArray; }
}
