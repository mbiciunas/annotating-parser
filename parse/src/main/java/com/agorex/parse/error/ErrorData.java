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
package com.agorex.parse.error;

import java.util.Arrays;

import com.agorex.parse.utility.AbstractResizable;


/**
 *
 * @author mbiciunas
 *
 */
public final class ErrorData extends AbstractResizable {

   private transient String[] error;


   /**
    * @param capacity initial number of elements in error set
    */
   public ErrorData(final int capacity) {
      super(capacity);
      error = new String[capacity];
   }


   /**
    * @param newError error information
    */
   public void add(final String newError) {
      increment();

      error[super.getSize()] = newError;
   }


   /**
    * @param index position of error to return
    * @return error identified by the index
    */
   String getError(final int index) {
      if (index < 0 || index > super.getSize()) {
         throw new IllegalArgumentException("index out of range");
      }

      return error[index];
   }


   /**
    * @return true if there are no errors
    */
   public boolean isErrorFree() {
      return super.getSize() < 0 ? true : false;
   }


   /**
    * @return true if there are errors
    */
   public boolean isErrors() {
      return super.getSize() >= 0 ? true : false;
   }


   @Override
   protected void addCapacity(final int newCapacity) {
      error = Arrays.copyOf(error, newCapacity);
   }
}
