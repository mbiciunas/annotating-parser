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

import java.util.Arrays;

import com.agorex.parse.utility.AbstractResizable;


/**
 * @author mbiciunas
 *
 */
public final class TokenData extends AbstractResizable {

   private static final int OFFSET_START = 0;
   private static final int OFFSET_END = 1;
   private static final int OFFSET_TYPE = 2;
   private static final int OFFSET_WIDTH = 3;

   private transient int[] result;


   /**
    * @param capacity initial number of elements in token set.
    */
   public TokenData(final int capacity) {
      super(capacity, OFFSET_WIDTH);
      result = new int[capacity];
   }


   /**
    * @param pointerStart start position for the token.
    * @param pointerEnd end position for the token.
    * @param annotation value of annotation.
    */
   public void add(final int pointerStart, final int pointerEnd, final int annotation) {
      increment();

      result[super.getMaxOffset(OFFSET_START)] = pointerStart;
      result[super.getMaxOffset(OFFSET_END)] = pointerEnd;
      result[super.getMaxOffset(OFFSET_TYPE)] = annotation;
   }


   /**
    * @param index position of token start pointer to return.
    * @return starting pointer identified by the index.
    */
   public int getStartPointer(final int index) {
      return result[super.getIndexOffset(index, OFFSET_START)];
   }


   /**
    * @param index position of end pointer to return.
    * @return ending pointer identified by the index.
    */
   public int getEndPointer(final int index) {
      return result[super.getIndexOffset(index, OFFSET_END)];
   }


   /**
    * @param index position of annotation to return.
    * @return annotation identified by the index.
    */
   public int getAnnotation(final int index) {
      return result[super.getIndexOffset(index, OFFSET_TYPE)];
   }


   /**
    * @param index position of token width to return.
    * @return width of token identified by the index.
    */
   public int getTokenWidth(final int index) {
      return result[super.getIndexOffset(index, OFFSET_END)] - result[super.getIndexOffset(index, OFFSET_START)];
   }


   @Override
   protected void addCapacity(final int newCapacity) {
      result = Arrays.copyOf(result, newCapacity);
   }
}
