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
import java.util.Random;


/**
 * @author mbiciunas
 *
 */
public final class DataSelect {

   private static List<String> arraySelect = new ArrayList<>();
   private static int arraySize;
   private static final transient Random RANDOM_NUMBER = new Random(System.currentTimeMillis());


   /**
    * Private constructor - all methods are static.
    */
   private DataSelect() {
   }


   /**
    * @return random statement
    */
   public static String random() {
      if (arraySize == 0) {
         makeRandom();
      }

      return arraySelect.get(RANDOM_NUMBER.nextInt(arraySize));
   }


   private static String simple() {
      final StringBuilder select = new StringBuilder(50);

      select.append("SELECT column1 ");
      select.append("FROM table1 ");
      select.append("WHERE column1 = 123");

      return select.toString();
   }


   private static String correlated() {
      final StringBuilder select = new StringBuilder(500);

      select.append("SELECT column1 ");
      select.append("FROM t1 AS \"x\" ");
      select.append("WHERE x.column1 = ( ");
      select.append("   SELECT column1 ");
      select.append("   FROM t2 AS x ");
      select.append("   WHERE x.column1=( ");
      select.append("      SELECT column1 ");
      select.append("      FROM t3 ");
      select.append("      WHERE x.column2 = t3.column1");
      select.append("   )");
      select.append(')');

      return select.toString();
   }


   private static synchronized void makeRandom() {
      final RandomCase randomCase = new RandomCase();

      if (arraySize == 0) {
         randomCase.makeRandomMix(simple());
         randomCase.makeRandomMix(correlated());

         arraySelect = randomCase.getArraySelect();

         arraySize = arraySelect.size();
      }
   }
}
