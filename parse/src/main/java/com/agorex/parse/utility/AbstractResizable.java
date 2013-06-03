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
package com.agorex.parse.utility;



/**
 * @author mbiciunas
 *
 */
public abstract class AbstractResizable {

   private final transient int capacityInitial;
   private final transient int offsetWidth;

   private transient int capacityCurrent;
   private transient int size;


   /**
    * @param capacity initial size of the subclass array
    */
   protected AbstractResizable(final int capacity) {
      this(capacity, 1);
   }


   /**
    * @param capacity initial size of the subclass array
    * @param offsetWidth number of array elements needed to define one entry in the subclass array
    */
   protected AbstractResizable(final int capacity, final int offsetWidth) {
      if (capacity < offsetWidth) {
         throw new IllegalArgumentException("Initial capacity of " + capacity + " must be greater than or equal to the offset width " + offsetWidth);
      }

      capacityInitial = capacity;
      capacityCurrent = capacity;
      size = -1;
      this.offsetWidth = offsetWidth;
   }


   /**
    * @param newCapacity number elements needed in the subclass array
    */
   protected abstract void addCapacity(final int newCapacity);


   /**
    *
    */
   public final void initialize() {
      size = -1;
   }


   /**
    * @return number of elements in the subclass array
    */
   public final int getSize() { return size; }


   /**
    * @param size number of elements in the subclass array
    */
   protected final void setSize(final int size) { this.size = size; }


   /**
    * @param offset amount to offset from the last index
    * @return offset from the last index
    */
   protected final int getMaxOffset(final int offset) {
      return size * offsetWidth + offset;
   }


   /**
    * @param index position of the element to offset from
    * @param offset amount to offset from the start of the index
    * @return offset from the start of the index
    */
   protected final int getIndexOffset(final int index, final int offset) {
      rangeCheck(index, offset);

      return index * offsetWidth + offset;
   }


   /**
    *
    */
   protected final void increment() {
      if ((size + 2) * offsetWidth > capacityCurrent) {
         capacityCurrent += capacityInitial;
         addCapacity(capacityCurrent);
      }

      ++size;
   }


   private void rangeCheck(final int index, final int offset) {
      if (offset < 0 || offset > offsetWidth) {
         throw new IllegalArgumentException("offset " + offset + " must be between 0 and the maximum offset " + offsetWidth);
      }

      rangeCheck(index);
   }


   private void rangeCheck(final int index) {
      if (index < 0 || index > size) {
         throw new IllegalArgumentException("index value " + index + " must be between 0 and the maximum index " + size);
      }
   }
}
