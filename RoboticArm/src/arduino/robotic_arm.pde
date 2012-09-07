#include <AFMotor.h>

/****************************
* Serial Format:
* Byte 0: Motor (1-4)
* Byte 1: Direction ('f' or 'b')
* ****************************/

#define DURATION 10   // 10ms motor duration

AF_DCMotor motor1(1, MOTOR12_64KHZ); // create motor #1, 64KHz pwm
AF_DCMotor motor2(4, MOTOR12_64KHZ); // create motor #2, 64KHz pwm
AF_DCMotor motor3(2); // create motor #3
AF_DCMotor motor4(3); // create motor #4

void setup() {
  Serial.begin(9600);           // set up Serial library at 9600 bps
  Serial.println("Motor test!");
  motor1.setSpeed(200);     // set the speed to 200/255
  motor2.setSpeed(200);
  motor3.setSpeed(200);
  motor4.setSpeed(200);
  
}

void loop() {
  
  if (Serial.available() >= 2) // Read 3 bytes of information
  {
    char motor = Serial.read();
    char dir = Serial.read();
    switch(motor)
    {
       case '1':
         if (dir == 'f')
           motor1.run(FORWARD);
         else
           motor1.run(BACKWARD);
         delay(DURATION);
         motor1.run(RELEASE);
         break;
       case '2':
         if (dir == 'f')
           motor2.run(FORWARD);
         else
           motor2.run(BACKWARD);
         delay(DURATION);
         motor2.run(RELEASE);
         break;
       case '3':
         if (dir == 'f')
           motor3.run(FORWARD);
         else
           motor3.run(BACKWARD);
         delay(DURATION);
         motor3.run(RELEASE);
         break;
       case '4':
         if (dir == 'f')
           motor4.run(FORWARD);
         else
           motor4.run(BACKWARD);
         delay(DURATION);
         motor4.run(RELEASE);
         break;
     
       default:
         break;
    }   
  }
}