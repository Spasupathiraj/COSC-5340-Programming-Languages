{
    File Name: Assignment_1.pas
    Author: Saranath Raj Pasupathi Raj 
    Student ID: 6001185214
    Class Number: COSC 5340
    Section Number: 80955
    Semester: Master's in Computer Science, Fourth Semester (Fall 2023) 
    Assignment Number: Assignment 1
    Date Created: September 27, 2023
    Program Description: This programming assignment emphasizes Pascal language provisions for nested procedures
                        and block structure (in the imperative paradigm context), parameter transmission by
                        reference, alternation and iteration structures, file input/output, set operations, and
                        recursion.
                        Write a complete Pascal program which will input from a file a series of infix expression
                        character strings involving addition and multiplication on the set of single-digit integer
                        operands and then evaluate and output result of each expression to a file. An example of
                        each output line appears below:

 
}

program ExpressionEvaluator;

var
  CurrentCharacter: Char;    // Variable to store the current character being processed
  ExprValue: Integer;        // Variable to store the result of the expression
  ExpressionStr: string;     // To store the expression
  inputFile, outputFile: Text;

// Procedure to get the next character from the input file
procedure GetCharacter(var Token: Char);
begin
  // Check if the end of the input file has not been reached
  if not eof(inputFile) then
  begin
    // Read the next character from the input file and store it in the 'Token' variable
    read(inputFile, Token);
    // Add the read character to the 'ExpressionStr' to keep track of the entire expression
    ExpressionStr := ExpressionStr + Token;
  end
  else
  begin
    // If the end of the input file has been reached, set 'Token' to '@' as an end-of-file indicator
    Token := '@';
  end;
end;

// Forward declaration of the Expression procedure
procedure Expression(var CurrentCharacter: Char; var ExprValue: Integer); forward;
// Procedure to handle factors in expressions
procedure Factor(var CurrentCharacter: Char; var FactorValue: Integer);
var
  Value: Integer; // Temporary variable to store the result of sub-expressions
begin
  // Check if the current character is a digit (0-9)
  if CurrentCharacter in ['0'..'9'] then
  begin
    // Convert the character to an integer and assign it as the factor's value
    FactorValue := Ord(CurrentCharacter) - Ord('0');
    GetCharacter(CurrentCharacter); // Move to the next character
  end
  // Check if the current character is an opening parenthesis '('
  else if CurrentCharacter = '(' then
  begin
    GetCharacter(CurrentCharacter); // Move past the '(' character
    Expression(CurrentCharacter, Value); // Evaluate the sub-expression within the parentheses
    FactorValue := Value; // Assign the sub-expression's result as the factor's value
    // Check if the current character is a closing parenthesis ')'
    if CurrentCharacter = ')' then
      GetCharacter(CurrentCharacter) // Move past the ')' character
    else
      writeln('Error: Wrong parenthesis match: ', CurrentCharacter); // Handle mismatched parentheses
  end;
end;

// Procedure to handle terms in expressions
procedure Term(var CurrentCharacter: Char; var TermValue: Integer);
var
  FactorValue: Integer; // Variable to store the value of the current factor
begin
  Factor(CurrentCharacter, FactorValue); // Evaluate the first factor
  TermValue := FactorValue; // Initialize the term value with the first factor's value

  // While there are more factors to process (factors separated by '*')
  while CurrentCharacter = '*' do
  begin
    GetCharacter(CurrentCharacter); // Move past the '*' character
    Factor(CurrentCharacter, FactorValue); // Evaluate the next factor
    TermValue := TermValue * FactorValue; // Multiply the term's value by the factor's value
  end;
end;

// Main procedure to handle expressions
procedure Expression(var CurrentCharacter: Char; var ExprValue: Integer);
var
  TermValue: Integer; // Variable to store the value of the current term
begin
  Term(CurrentCharacter, TermValue); // Evaluate the first term
  ExprValue := TermValue; // Initialize the expression result with the first term's value

  // While there are more terms to process (terms separated by '+' or '-')
  while CurrentCharacter in ['+', '-'] do
  begin
    if CurrentCharacter = '+' then
    begin
      GetCharacter(CurrentCharacter); // Move past the '+' character
      Term(CurrentCharacter, TermValue); // Evaluate the next term
      ExprValue := ExprValue + TermValue; // Add the term's value to the expression result
    end
    else if CurrentCharacter = '-' then
    begin
      GetCharacter(CurrentCharacter); // Move past the '-' character
      Term(CurrentCharacter, TermValue); // Evaluate the next term
      ExprValue := ExprValue - TermValue; // Subtract the term's value from the expression result
    end;
  end;
end;

begin
  assign(inputFile, 'input.txt');   // Assign input file
  reset(inputFile);                 // Open input file for reading
  assign(outputFile, 'output.txt'); // Assign output file
  rewrite(outputFile);              // Open output file for writing

  while not eof(inputFile) do // While there are more characters to read in the input file
  begin
    ExpressionStr := ''; // Initialize the expression string
    GetCharacter(CurrentCharacter); // Get the next character from the input file
    Expression(CurrentCharacter, ExprValue); // Evaluate the expression

    if ExprValue > 0 then // If the expression result is positive
    begin
      // Print the expression and its value to both the output file and the console
      writeln(outputFile, 'THE VALUE OF ', ExpressionStr,' IS ', ExprValue);
      writeln('THE VALUE OF ', ExpressionStr,' IS ', ExprValue);
    end;
  end;

  close(inputFile);    // Close the input file
  close(outputFile);   // Close the output file
end.


