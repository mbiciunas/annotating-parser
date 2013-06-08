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

import com.agorex.parse.search.landmark.ResultSetLandmark;

/**
 * @author mbiciunas
 *
 */
public abstract class AbstractTestResultSetLandmark extends AbstractTest {

   /**
    * @param className name of the class that is being tested
    * @param expectedResultSet known correct result set
    * @param actualResultSet result set generated during test
    * @return true if actual result set matches expected result set
    */
   protected static final boolean validate(final String className, final ResultSetLandmark expectedResultSet, final ResultSetLandmark actualResultSet) {
      final int size = actualResultSet.getSize();
      String landmark;
      String correctLandmark;
//output(className, expectedResultSetLandmark, resultSetLandmark);
      assertEquals(className + " - Number of token ranges", expectedResultSet.getSize(), size);

      for (int index = 0; index <= size; ++index) {
         landmark = String.copyValueOf(actualResultSet.getLandmark(index));
         correctLandmark = String.copyValueOf(expectedResultSet.getLandmark(index));

         assertEquals(className + " - landmark", correctLandmark, landmark);
         assertEquals(className + " - token", expectedResultSet.getToken(index), actualResultSet.getToken(index));
      }

      return true;
   }


//   private void output(final String className, final ResultSetLandmark expectedResultSet, final ResultSetLandmark actualResultSet) {
//      System.out.println("*** " + className + " ***");
//      System.out.println("  Actual Max Index: " + actualResultSet.getSize());
//
//      for (int index = 0; index <= actualResultSet.getSize(); ++index) {
//         System.out.println("    Actual Landmark: " + String.copyValueOf(actualResultSet.getLandmark(index)) + "  Token: " + actualResultSet.getToken(index));
//      }
//
//      System.out.println();
//      System.out.println("  Expected Max Index: " + expectedResultSet.getSize());
//
//      for (int index = 0; index <= expectedResultSet.getSize(); ++index) {
//         System.out.print("    Expected Landmark: ");
//         System.out.print(String.copyValueOf(expectedResultSet.getLandmark(index)));
//         System.out.print("  Token: ");
//         System.out.print(expectedResultSet.getToken(index));
//         System.out.println();
//      }
//
//      System.out.println();
//      System.out.println();
//   }
}
