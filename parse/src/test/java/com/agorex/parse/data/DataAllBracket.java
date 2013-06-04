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
package com.agorex.parse.data;

import com.agorex.parse.search.ResultSetTokenRange;

/**
 * @author mbiciunas
 *
 */
public final class DataAllBracket {

   private final transient ResultSetTokenRange resultSetTokenRange = new ResultSetTokenRange(10);


//   /**
//    * @return token result set
//    */
//   public ResultSetTokenRange getResult() { return resultSetTokenRange; }


   /**
    * @param tokenStart value used to start the token range
    * @param tokenEnd value used to end the token range
    */
   public void add(final int tokenStart, final int tokenEnd) {
      resultSetTokenRange.add(tokenStart, tokenEnd);
   }


   /**
    * @return token result set
    */
   public ResultSetTokenRange getResultSetTokenRange() {
      return resultSetTokenRange;
   }


   /**
    * @return number of entries in result set
    */
   public int getSize() {
      return resultSetTokenRange.getSize();
   }


   /**
    * @param index position in the result set
    * @return value used to start the token range
    */
   public int getTokenStart(final int index) {
      return resultSetTokenRange.getTokenRange(index).getTokenStart();
   }


   /**
    * @param index position in the result set
    * @return value used to end the token range
    */
   public int getTokenEnd(final int index) {
      return resultSetTokenRange.getTokenRange(index).getTokenEnd();
   }
}
