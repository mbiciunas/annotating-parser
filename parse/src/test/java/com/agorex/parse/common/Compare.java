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
package com.agorex.parse.common;

import com.agorex.parse.ParseData;

/**
 * @author mbiciunas
 *
 */
public final class Compare {

   /**
    * Private constructor - all methods are static.
    */
   private Compare() {
   }


   public static boolean compare(final String statement, final ParseData parseData) {
      final String compareStatement;
      final String compareResult;

      //
      // Format the original statement and the results so
      // that they can be compared.
      //
      compareStatement = formatStatement(statement);
      compareResult = formatResult(parseData);

      //
      // Return true if the statement and results match.
      //
      return compareStatement.equals(compareResult);
   }


   private static String formatStatement(final String statement) {
      //
      // Remove all spaces from the original statement.
      //
      return statement.replace(" ", "");
   }


   private static String formatResult(final ParseData parseData) {
      final int size = parseData.getToken().getSize();
      final StringBuilder newResult = new StringBuilder();

      //
      // Combine all the segments from the result.
      //
      for (int index = 0; index < size; ++index) {
         newResult.append(parseData.getSource().getToken(parseData.getToken(), index));
      }

      return newResult.toString();
   }
}
