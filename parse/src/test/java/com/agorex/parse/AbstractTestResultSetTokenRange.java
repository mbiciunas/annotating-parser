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

/**
 * @author mbiciunas
 *
 */
public abstract class AbstractTestResultSetTokenRange extends AbstractTest {

   /**
    * @param className name of the class that is being tested
    * @param expectedResultSet known correct result set
    * @param actualResultSet result set generated during test
    * @return true if actual result set matches expected result set
    */
   protected final boolean validate(final String className, final ResultSetTokenRange expectedResultSet, final ResultSetTokenRange actualResultSet) {
      final int size = actualResultSet.getSize();
      int resultTokenStart;
      int resultTokenEnd;
      int correctTokenStart;
      int correctTokenEnd;
//output(className, expectedResultSetTokenRange, actualResultSetTokenRange);
      assertEquals(className + " - Number of token ranges", expectedResultSet.getSize(), size);

      for (int index = 0; index <= size; ++index) {
         resultTokenStart = actualResultSet.getTokenRange(index).getTokenStart();
         resultTokenEnd = actualResultSet.getTokenRange(index).getTokenEnd();
         correctTokenStart = expectedResultSet.getTokenRange(index).getTokenStart();
         correctTokenEnd = expectedResultSet.getTokenRange(index).getTokenEnd();

         assertEquals(className + " - token start", correctTokenStart, resultTokenStart);
         assertEquals(className + " - token end", correctTokenEnd, resultTokenEnd);
      }

      return true;
   }


//   private void output(final String className, final ResultSetTokenRange expectedResultSet, final ResultSetTokenRange actualResultSet) {
//      int resultTokenStart;
//      int resultTokenEnd;
//
//      System.out.println("*** " + className + " ***");
//      System.out.println("  Generated Max Index: " + actualResultSet.getSize());
//
//      for (int index = 0; index <= actualResultSet.getSize(); ++index) {
//         resultTokenStart = actualResultSet.getTokenRange(index).getTokenStart();
//         resultTokenEnd = actualResultSet.getTokenRange(index).getTokenEnd();
//
//         System.out.println("    Generated Token Start: " + resultTokenStart + "  Token End: " + resultTokenEnd);
//      }
//
//      System.out.println();
//      System.out.println("  Calculated Max Index: " + expectedResultSet.getSize());
//
//      for (int index = 0; index <= expectedResultSet.getSize(); ++index) {
//         resultTokenStart = expectedResultSet.getTokenRange(index).getTokenStart();
//         resultTokenEnd = expectedResultSet.getTokenRange(index).getTokenEnd();
//
//         System.out.println("    Calculated Token Start: " + resultTokenStart + "  Token End: " + resultTokenEnd);
//      }
//
//      System.out.println();
//      System.out.println();
//   }
}
