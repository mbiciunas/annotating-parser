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

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;

/**
 * @author mbiciunas
 *
 */
final class RandomCase {

   private final transient List<String> arrayStatement = new ArrayList<String>();
   private final transient Random randomGenerator = new Random(System.currentTimeMillis());


   List<String> getArraySelect() { return arrayStatement; }


   void makeRandomMix(final String statement) {
      arrayStatement.add(statement);
      arrayStatement.add(caseLower(statement));
      arrayStatement.add(caseUpper(statement));
      arrayStatement.add(caseMix(statement));
   }


   private String caseLower(final String statement) {
      return statement.toLowerCase(Locale.getDefault());
   }


   private String caseUpper(final String statement) {
      return statement.toUpperCase(Locale.getDefault());
   }


   private String caseMix(final String statement) {
      final char[] mixCase = statement.toCharArray();
      final int length = mixCase.length;
      int randomLower;
      int randomUpper;

      for (int index = 0; index < length; ++index) {
         randomLower = randomGenerator.nextInt(length);
         randomUpper = randomGenerator.nextInt(length);

         mixCase[randomLower] = statement.substring(randomLower, randomLower + 1).toLowerCase().charAt(0);
         mixCase[randomUpper] = statement.substring(randomUpper, randomUpper + 1).toUpperCase().charAt(0);
      }

      return String.valueOf(mixCase);
   }
}
