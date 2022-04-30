package Main;

import java.util.Stack;
public class ParenthesesChecker {

    public boolean checkParentheses(String input) {
        // creating a reference variable stack (which is a collection of items)
        // this stack will accept datatype Character- (Using Characters so I don't have to chop  the string )
        // + this stack is called "stackWithStrings"

        Stack<Character> stackWithCharacters= new Stack<>();

        // for the array input , iterating from index i =0 all the way down to length of the array increments of 1

        for (int i = 0; i < input.length(); i++) {

            // the character at index is what the pointer ref variable is pointing to, hence the function input.charAt(i)
            // is stored in this variable "pointer"
            // note it moves in sync with i as we move along the input array -

            // pointer 0= character at index 0, pointer 1= character at index 1, etc

            char pointer = input.charAt(i);

            // checking for lone opening brackets of all types:
            // if pointer  found any opening brackets push (add) it to the stack

            if (pointer == '(' || pointer == '[' || pointer == '<' || pointer == '{'){
                stackWithCharacters.push(pointer);

             // but if instead we come across a closing bracket :
            } else if (pointer == ')' || pointer == ']' || pointer == '>' || pointer == '}'){

                // scenario 1: STACK IS EMPTY  (-> no opening)
                if (stackWithCharacters.isEmpty()){   // if stack is empty meaning no opening, return false- cant pair
                    return false;

                // scenario 2: STACK IS NOT EMPTY  ()

                    // however, if- we found closing ")" + stack is not empty

                } else {       //else because when all the above fails (all above else in this nest (dark green  region))
/*
                     look at the last item that was added in the stack- (PEEK)

                     if we have an opening in stack of the required type to close the one we have in pointer-
                     remove opening from the stack- happy pair

                     NOTE: needs to be of required type because if we have ( and the last item in stack = },  }
                     wont close ( , doesn't match.  You could well have the correct type later along the line but
                     that could mean that it didn't close properly e.g. :   ( a b c < } )
                     in this example, the last bracket we added would have been }.

                     we  have interfering brackets in between that don't allow for a close!


                     We will keep matching every closing we come across with an opening of its type from the stack
                     until the stack is empty
*/
                    if     ((stackWithCharacters.peek() == '(' && pointer == ')') ||
                            (stackWithCharacters.peek() == '{' && pointer == '}') ||
                            (stackWithCharacters.peek() == '[' && pointer == ']') ||
                            (stackWithCharacters.peek() == '<' && pointer == '>')) {

                        //  we want to remove opening bracket from stack- happy pair are free to go
                        stackWithCharacters.pop();

                    }
                }
            }

        }   // if the stack in  the end is empty, return true - no more pairing needed- all happy pairs
        if (stackWithCharacters.empty()){
            return true;
            // if it's not empty it means that we have some unpaired brackets-
            // pointer found closing but it cannot pair with last added bracket in stack

            // in which case return a false
        } else {
            return false;
        }
    }

}