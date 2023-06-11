pipeline {
  agent any
  stages {
      stage('Build Artifact') {
            steps {
              sh "mvn clean package -DskipTests=true"
              archive 'target/*.jar'
            }
        }
      stage('Units tests') {
        steps {
             sh "mvn test"
        }
      }
      }

       post {

          always  {
               junit 'target/surefire-reports/*.xml'
               jacoco execPattern: 'target/jacoco.exec'
             //  pitmutation  mutationStatsFile: '**/target/pit-reports/**/mutations.xml'
              // dependencyCheckPublisher   pattern: 'target/dependency-check-report.xml'
                }
             }


}