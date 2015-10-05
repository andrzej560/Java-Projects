package pl.polsl.andrzej.kowol.sort.model;

/**
 * Enumeration type which is responsible for choose sort type: ascending or descending.
 * 
 * @author Andrzej Kowol
 * @version 2.0
 */
    public enum ChooseSortType{
        
        ASCENDING(true),
        DESCENDING(false),
        ASCEND(true),
        DESCEND(false),
        ASC(true),
        DESC(false),
        A(true),
        D(false);
        
        private boolean value; //true for ascending, false for descending
        
        /**
         * Non-parameter constructor.
         * 
         */
        ChooseSortType(){
            this.value = true;
        }
        
        /**
         * Constructor with parameter.
         * 
         * @param value Type of sort.
         */
        ChooseSortType(boolean value){
            this.value = value;
        }
        
        /**
         * Method which return value of sort.
         * 
         * @return value Return sort type.
         */
        public boolean getValue(){
            return value;
        }
    }
    
    