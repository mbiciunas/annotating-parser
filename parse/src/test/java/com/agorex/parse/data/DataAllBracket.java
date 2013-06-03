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

public final class DataAllBracket {

   private final transient ResultSetTokenRange resultSetTokenRange = new ResultSetTokenRange(10);


   public ResultSetTokenRange getResult() { return resultSetTokenRange; }


   public void add(final int tokenStart, final int tokenEnd) {
      resultSetTokenRange.add(tokenStart, tokenEnd);
   }


   public ResultSetTokenRange getResultSetTokenRange() {
      return resultSetTokenRange;
   }


   public int getSize() {
      return resultSetTokenRange.getSize();
   }


   public int getTokenStart(final int index) {
      return resultSetTokenRange.getTokenRange(index).getTokenStart();
   }


   public int getTokenEnd(final int index) {
      return resultSetTokenRange.getTokenRange(index).getTokenEnd();
   }
}
