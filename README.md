
<h1> AI (Simulated Intelligence) playing boggle built on top of Java SpringBoot </h1>


<h4> How it works </h4>
<ul> 
  <li> A boggle board is generated </li>
  <li> The AI has two choices 
    <ul> 
      <li> 
        Play 
        <ul> 
          <li> The AI creates a list of every possible permutation from the boggle board </li>
          <li> It creates a string of every possible word between 3 and 7 words </li>
          <li> The AI then checks the strings from its own word database </li>
          <li> If the string match a word, the AI then adds the word to a word found for current game Array </li>
        </ul>
      </li>
      <li> 
        Train 
        <ul> 
          <li> The AI creates a list of every possible permutation from the boggle board </li>
          <li> It creates a string of every possible word between 3 and 7 words </li>
          <li> The AI then checks the strings created using an external word database </li>
          <li> If the string match a word, the AI then adds the word to it's own word database </li>
          <li> Once all permuations are checked ( training completes ), the AI serializes for future use. </li>
        </ul>
      </li>
    </ul>
  </li>

<hr> 

<h1> Using the AI </h2>
<h2> Run the program and connect to http://localhost:8080 </h2>
<h3> Endpoints </h3>
<h5> /play </h5>
  <p> Tells the AI to play with the current boggle borad. </p>
<h5> /train </h5>
  <p> Start training the AI on the current boggle board. </p>
<h5> /serializeWordDatabase </h5>
  <p> Serialize the AI's current vocabulary. </p>
<h5> /addKnownWord </h5>
  <p> Adds a word to the AI's vocabulary (defaults to the word: software). </p>
<h5> /getCurrentBoard </h5>
  <p> Returns the current boggle board. </p>
<h5> /setBoard </h5>
  <p> Set a boggle board. Format: "a","b","c","q","w","e" </p>
<h5> /generateBoard </h5>
  <p> Generates a new boggle board </p>
<h5> /listAllKnownWords </h5>
  <p> Lists all known words </p>
 
 

