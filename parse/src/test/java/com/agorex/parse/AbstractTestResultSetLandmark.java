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

public abstract class AbstractTestResultSetLandmark extends AbstractTest {

   protected final boolean validate(final String className, final ResultSetLandmark correctResultSet, final ResultSetLandmark resultSet) {
      final int size = resultSet.getSize();
      String landmark;
      String correctLandmark;
//output(className, correctResultSetLandmark, resultSetLandmark);
      assertEquals(className + " - Number of token ranges", correctResultSet.getSize(), size);

      for (int index = 0; index <= size; ++index) {
         landmark = String.copyValueOf(resultSet.getLandmark(index));
         correctLandmark = String.copyValueOf(correctResultSet.getLandmark(index));

         assertEquals(className + " - landmark", correctLandmark, landmark);
         assertEquals(className + " - token", correctResultSet.getToken(index), resultSet.getToken(index));
      }

      return true;
   }


//   private void output(final String className, final ResultSetLandmark correctResultSet, final ResultSetLandmark resultSet) {
//      System.out.println("*** " + className + " ***");
//      System.out.println("  Generated Max Index: " + resultSet.getSize());
//
//      for (int index = 0; index <= resultSet.getSize(); ++index) {
//         System.out.println("    Generated Landmark: " + String.copyValueOf(resultSet.getLandmark(index)) + "  Token: " + resultSet.getToken(index));
//      }
//
//      System.out.println();
//      System.out.println("  Calculated Max Index: " + correctResultSet.getSize());
//
//      for (int index = 0; index <= correctResultSet.getSize(); ++index) {
//         System.out.print("    Calculated Landmark: ");
//         System.out.print(String.copyValueOf(correctResultSet.getLandmark(index)));
//         System.out.print("  Token: ");
//         System.out.print(correctResultSet.getToken(index));
//         System.out.println();
//      }
//
//      System.out.println();
//      System.out.println();
//   }
}
