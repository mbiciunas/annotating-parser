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
package com.agorex.parse.search;


/**
 * @author mbiciunas
 *
 */
public final class TokenRange {

   private transient String name;
   private transient int tokenStart;
   private transient int tokenEnd;


   /**
    *
    */
   public TokenRange() {
      tokenStart = -1;
      tokenEnd = -1;
   }


   /**
    * @param tokenStart index of the start token.
    * @param tokenEnd index of the end token.
    */
   public TokenRange(final int tokenStart, final int tokenEnd) {
      this.tokenStart = tokenStart;
      this.tokenEnd = tokenEnd;
   }


   /**
    * @param name name of the token range.
    * @param tokenStart index of the start token.
    * @param tokenEnd index of the end token.
    */
   TokenRange(final String name, final int tokenStart, final int tokenEnd) {
      this.name = name;
      this.tokenStart = tokenStart;
      this.tokenEnd = tokenEnd;
   }


   /**
    * @return name attached to this token range.
    */
   public String getName() { return name; }


   /**
    * @param name name of the token range.
    */
   public void setName(final String name) { this.name = name; }


   /**
    * @return index of the start token.
    */
   public int getTokenStart() { return tokenStart; }


   /**
    * @param tokenStart index of the start token.
    */
   public void setStart(final int tokenStart) { this.tokenStart = tokenStart; }


   /**
    * @return index of the end token.
    */
   public int getTokenEnd() { return tokenEnd; }


   /**
    * @param tokenEnd index of the end token.
    */
   public void setEnd(final int tokenEnd) { this.tokenEnd = tokenEnd; }


   /**
    * @return number of tokens between the star and end of this token range.
    */
   public int getWidth() { return tokenEnd - tokenStart + 1; }
}
