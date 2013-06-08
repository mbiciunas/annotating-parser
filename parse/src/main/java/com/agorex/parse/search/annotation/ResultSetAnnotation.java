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
package com.agorex.parse.search.annotation;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Comparator;

import com.agorex.parse.utility.AbstractResizable;



/**
 * @author mbiciunas
 *
 */
public final class ResultSetAnnotation extends AbstractResizable {

   private transient ResultSingleAnnotation[] resultSingleAnnotation;


   /**
    * @param capacity initial number of elements in result set.
    */
   public ResultSetAnnotation(final int capacity) {
      super(capacity);
      resultSingleAnnotation = new ResultSingleAnnotation[capacity];
   }


   /**
    * @param annotation value of annotation.
    * @param token value of token being added.
    */
   public void add(final int annotation, final int token) {
      increment();

      resultSingleAnnotation[super.getSize()] = new ResultSingleAnnotation(annotation, token);
   }


   /**
    * @param index position of annotation to return
    * @return annotation identified by the index
    */
   public int getAnnotation(final int index) {
      return resultSingleAnnotation[index].getAnnotation();
   }


   /**
    * @param index position of token to return
    * @return token identified by the index
    */
   public int getToken(final int index) {
      return resultSingleAnnotation[index].getToken();
   }


   /**
    *
    */
   void sort() {
      Arrays.sort(resultSingleAnnotation, new ComparatorToken());
   }


   /**
    * Comparator used for sorting the result set.  Sort ascending
    * based on token value.
    *
    * @author mbiciunas
    *
    */
   private static class ComparatorToken implements Comparator<ResultSingleAnnotation>, Serializable {
      private static final long serialVersionUID = 1L;

      public ComparatorToken() { }

      @Override
      public int compare(final ResultSingleAnnotation result1, final ResultSingleAnnotation result2) {
         final int compare;

         if (result2 == null) {
            compare = -1;
         }
         else if (result1 == null) {
            compare = 1;
         }
         else {
            compare = result1.getToken() - result2.getToken();
         }
         return compare;
      }
   }


   @Override
   protected void addCapacity(final int newCapacity) {
      resultSingleAnnotation = Arrays.copyOf(resultSingleAnnotation, newCapacity);
   }
}
