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
 stage('sonarqube analysis') {
          steps {

sh "mvn sonar:sonar  -Dsonar.projectKey=kataforfun-application   -Dsonar.host.url=http://desecops-majdi.eastus.cloudapp.azure.com:9000   -Dsonar.token=sqp_2e8ec1375826a890f2713874abcd8d29b7bd3645"
          }
       }
       stage('Docker build and push') {
                  steps {
                  withDockerRegistry(credentialsId: "docker-hub", url: "") {
                    sh 'printenv'
                    sh 'sudo docker build -t majditaleb/kataforfun-app:""$GIT_COMMIT"" .'
                    sh 'docker push  majditaleb/kataforfun-app:""$GIT_COMMIT""'
                    }
                  }
              }

         stage('K8S Deployment - DEV') {
                        steps {


                              withKubeConfig([credentialsId: 'kubeconfig']) {
                               sh "sed -i 's#replace#majditaleb/kataforfun-app:${GIT_COMMIT}#g' k8s_deployment_service.yaml"
                               sh "kubectl  apply -f k8s_deployment_service.yaml"
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