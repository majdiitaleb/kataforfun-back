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
      },
       stage('Docker build and push') {
                  steps {
                  withDockerRegistry(credentialsId: "docker-hub", url: "") {
                    sh 'printenv'
                    sh 'sudo docker build -t majditaleb/kataforfun-app:""$GIT_COMMIT"" .'
                    sh 'docker push  majditaleb/kataforfun-app:""$GIT_COMMIT""'
                    }
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