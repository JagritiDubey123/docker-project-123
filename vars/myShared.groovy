def call(String name, String dayOfWeek){
  sh 'echo Hi Team, How are you!!!'
  sh "date"
  sh "echo hello "
  sh " Hello ${name}, Today is ${dayOfWeek"}
 // def call() {
    // Execute npm install command
    sh "sudo apt install npm"
    sh "npm test"
}


