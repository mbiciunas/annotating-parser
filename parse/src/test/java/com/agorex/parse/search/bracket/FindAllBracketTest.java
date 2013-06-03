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
package com.agorex.parse.search.bracket;


import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.agorex.parse.AbstractTestResultSetTokenRange;
import com.agorex.parse.data.Data;
import com.agorex.parse.search.ResultSetTokenRange;

public final class FindAllBracketTest extends AbstractTestResultSetTokenRange {

   @Test
   public void testEmbeddedExclusive() {
      for (int index = 0; index < getDataArray().size(); ++index) {
         assertTrue(getDataArray().getData(index).getClassName() + " - Run failed", run(getDataArray().getData(index)));
      }
   }


   private boolean run(final Data data) {
      final ResultSetTokenRange resultSetTokenRange;

      initialize(data.getStatement());

      resultSetTokenRange = FindAllBracket.findExclusive(getParseData(), getResultSingleTokenRange());

      validate(data.getClassName(), data.getAllBracket().getResultSetTokenRange(), resultSetTokenRange);

      return true;
   }
}
