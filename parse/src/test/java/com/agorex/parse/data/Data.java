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


/**
 * @author mbiciunas
 *
 */
public final class Data {

   private transient String statement;
   private transient String description;
   private transient String className;

   private transient DataToken dataToken = new DataToken();
   private transient DataAnnotationState dataAnnotationState = new DataAnnotationState();
   private transient DataAllBracket dataAllBracket = new DataAllBracket();
   private transient DataAllAnnotation dataAllAnnotation = new DataAllAnnotation();
   private transient DataAllLandmark dataAllLandmark = new DataAllLandmark();
   private transient DataAllLandmarkForward dataAllLandmarkForward = new DataAllLandmarkForward();
   private transient DataAllLandmarkRange dataAllLandmarkRange = new DataAllLandmarkRange();


   /**
    * @return text to be tokenized
    */
   public String getStatement() { return statement; }


   /**
    * @param statement text to be tokenized
    */
   public void setStatement(final String statement) { this.statement = statement; }


   /**
    * @return printable description of the statement
    */
   public String getDescription() { return description; }


   /**
    * @param description printable description of the statement
    */
   public void setDescription(final String description) { this.description = description; }


   /**
    * @return name of the class that is being tested
    */
   public String getClassName() { return className; }


   /**
    * @param className name of the class that is being tested
    */
   public void setClassName(final String className) { this.className = className; }


   /**
    * @return correct set of tokens for a statement
    */
   public DataToken getToken() { return dataToken; }


   /**
    * @return annotation state
    */
   public DataAnnotationState getAnnotationState() { return dataAnnotationState; }


   /**
    * @return correct set of brackets for a statement
    */
   public DataAllBracket getAllBracket() { return dataAllBracket; }


   /**
    * @return correct set of annotations for a statement
    */
   public DataAllAnnotation getAllAnnotation() { return dataAllAnnotation; }


   /**
    * @return correct set of landmarks for a statement
    */
   public DataAllLandmark getAllLandmark() { return dataAllLandmark; }


   /**
    * @return correct set of forward landmarks for a statement
    */
   public DataAllLandmarkForward getAllLandmarkForward() { return dataAllLandmarkForward; }


   /**
    * @return correct set of landmark ranges for a statement
    */
   public DataAllLandmarkRange getAllLandmarkRange() { return dataAllLandmarkRange; }
}
