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
package com.agorex.parse.token;

import com.agorex.parse.ParseData;


/**
 * @author mbiciunas
 *
 */
public final class Token {

   private Token() {
      //
      // All methods are static
      //
   }


   /**
    * @param parseData structure containing all parse data
    */
   public static void parse(final ParseData parseData) {
      final SourceData sourceData = parseData.getSource();
      final TokenData tokenData = parseData.getToken();
      final ConfigurationData configurationData = parseData.getConfigurationData();
      int pointerStart = 0;
      int pointerEnd = 0;
      int indexAnnotation = 0;

      while (pointerEnd < sourceData.getSourceLength()) {
         indexAnnotation = configurationData.findCharacter(sourceData.getCharacter(pointerEnd));

         if (indexAnnotation == -1) {
            ++pointerEnd;
         }
         else if (configurationData.getAction(indexAnnotation) == ConfigurationData.ACTION_SKIP) {
            if (pointerEnd > pointerStart) {
               tokenData.add(pointerStart, pointerEnd, 0);
            }
            else {
               ++pointerEnd;
            }

            pointerStart = pointerEnd;
         }
         else if (configurationData.getAction(indexAnnotation) == ConfigurationData.ACTION_ANNOTATE) {
            if (pointerStart < pointerEnd) {
               tokenData.add(pointerStart, pointerEnd, 0);
               pointerStart = pointerEnd;
            }

            if (pointerStart == pointerEnd) {
               ++pointerEnd;
               tokenData.add(pointerStart, pointerEnd, configurationData.getAnnotation(indexAnnotation));
               pointerStart = pointerEnd;
            }

         }
      }

      if (pointerStart < pointerEnd) {
         tokenData.add(pointerStart, pointerEnd, 0);
      }
   }
}
