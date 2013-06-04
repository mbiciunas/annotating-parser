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
import com.agorex.parse.token.TokenData;

/**
 * @author mbiciunas
 *
 */
public final class Console {

   /**
    * Private constructor - all methods are static.
    */
   private Console() {
   }


   /**
    * @param parseData object containing the parse data
    */
   public static void outputSource(final ParseData parseData) {
      System.out.println(parseData.getSource().getSource(0, parseData.getSource().getSourceLength()) + "\n");
   }


   /**
    * @param parseData object containing all the parse data
    */
   public static void outputOneLine(final ParseData parseData) {
      final int size = parseData.getToken().getSize();

      for (int index = 0; index < size; ++index) {
         System.out.print(parseData.getSource().getToken(parseData.getToken(), index) + " ");
      }

      System.out.println();
      System.out.println();
   }


   /**
    * @param parseData object containing all the parse data
    */
   public static void outputFull(final ParseData parseData) {
      final TokenData tokenData = parseData.getToken();
      final int size = tokenData.getSize();
      int indexStart;
      int indexEnd;
      int annotation;
      String token;

      for (int index = 0; index <= size; ++index) {
         indexStart = tokenData.getStartPointer(index);
         indexEnd = tokenData.getEndPointer(index);
         annotation = tokenData.getAnnotation(index);
         token = parseData.getSource().getToken(parseData.getToken(), index);

         System.out.println("Count: " + index + "  Start: " + indexStart + "  End: " + indexEnd + "  Annotation: " + annotation + "  Token: " + token);
      }
      System.out.println();
      System.out.println();
   }
}
