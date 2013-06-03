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


import static org.junit.Assert.assertEquals;

import com.agorex.parse.search.ResultSetTokenRange;

public abstract class AbstractTestResultSetTokenRange extends AbstractTest {

   protected final boolean validate(final String className, final ResultSetTokenRange correctResultSet, final ResultSetTokenRange resultSet) {
      final int size = resultSet.getSize();
      int resultTokenStart;
      int resultTokenEnd;
      int correctTokenStart;
      int correctTokenEnd;
//output(className, correctResultSetTokenRange, resultSetTokenRange);
      assertEquals(className + " - Number of token ranges", correctResultSet.getSize(), size);

      for (int index = 0; index <= size; ++index) {
         resultTokenStart = resultSet.getTokenRange(index).getTokenStart();
         resultTokenEnd = resultSet.getTokenRange(index).getTokenEnd();
         correctTokenStart = correctResultSet.getTokenRange(index).getTokenStart();
         correctTokenEnd = correctResultSet.getTokenRange(index).getTokenEnd();

         assertEquals(className + " - token start", correctTokenStart, resultTokenStart);
         assertEquals(className + " - token end", correctTokenEnd, resultTokenEnd);
      }

      return true;
   }


//   private void output(final String className, final ResultSetTokenRange correctResultSet, final ResultSetTokenRange resultSet) {
//      int resultTokenStart;
//      int resultTokenEnd;
//
//      System.out.println("*** " + className + " ***");
//      System.out.println("  Generated Max Index: " + resultSet.getSize());
//
//      for (int index = 0; index <= resultSet.getSize(); ++index) {
//         resultTokenStart = resultSet.getTokenRange(index).getTokenStart();
//         resultTokenEnd = resultSet.getTokenRange(index).getTokenEnd();
//
//         System.out.println("    Generated Token Start: " + resultTokenStart + "  Token End: " + resultTokenEnd);
//      }
//
//      System.out.println();
//      System.out.println("  Calculated Max Index: " + correctResultSet.getSize());
//
//      for (int index = 0; index <= correctResultSet.getSize(); ++index) {
//         resultTokenStart = correctResultSet.getTokenRange(index).getTokenStart();
//         resultTokenEnd = correctResultSet.getTokenRange(index).getTokenEnd();
//
//         System.out.println("    Calculated Token Start: " + resultTokenStart + "  Token End: " + resultTokenEnd);
//      }
//
//      System.out.println();
//      System.out.println();
//   }
}
