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

import com.agorex.parse.token.TokenData;


/**
 * @author mbiciunas
 *
 */
public final class DataToken {

   private final transient TokenData tokenData = new TokenData(100);


   /**
    * @param pointerStart position of the start of the token
    * @param pointerEnd position of the start of the token
    * @param annotation value of the annotation
    */
   public void add(final int pointerStart, final int pointerEnd, final int annotation) {
      tokenData.add(pointerStart, pointerEnd, annotation);
   }


   /**
    * @return number of entries in the token set
    */
   public int getSize() {
      return tokenData.getSize();
   }


   /**
    * @param index position in the token set
    * @return value of pointer at start of token
    */
   public int getPointerStart(final int index) {
      return tokenData.getStartPointer(index);
   }


   /**
    * @param index position in the token set
    * @return value of pointer at end of token
    */
   public int getPointerEnd(final int index) {
      return tokenData.getEndPointer(index);
   }


   /**
    * @param index position in the token set
    * @return value of annotation
    */
   public int getAnnotation(final int index) {
      return tokenData.getAnnotation(index);
   }
}
