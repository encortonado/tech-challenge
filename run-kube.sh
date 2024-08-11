#!/bin/sh

option=$1

case $option in
  db) 
    kubectl apply -f ./infra/kubernetes/configmap/db-deployment-configmap.yaml
    kubectl apply -f ./infra/kubernetes/secrets/postgres-secrets.yaml
    kubectl apply -f ./infra/kubernetes/volume.yaml
    kubectl apply -f ./infra/kubernetes/deployments/db-deployment.yaml
    kubectl apply -f ./infra/kubernetes/services/db-service.yaml
    
    ;;
  app)
    kubectl apply -f ./infra/kubernetes/configmap/deployment-configmap.yaml
    kubectl apply -f ./infra/kubernetes/secrets/challenge-secrets.yaml
    kubectl apply -f ./infra/kubernetes/deployments/deployment.yaml
    kubectl apply -f ./infra/kubernetes/services/service.yaml
    ;;
  all) 
    kubectl apply -f ./infra/kubernetes/configmap/db-deployment-configmap.yaml
    kubectl apply -f ./infra/kubernetes/secrets/postgres-secrets.yaml
    kubectl apply -f ./infra/kubernetes/volume.yaml
    kubectl apply -f ./infra/kubernetes/deployments/db-deployment.yaml
    kubectl apply -f ./infra/kubernetes/services/db-service.yaml

    kubectl apply -f ./infra/kubernetes/configmap/deployment-configmap.yaml
    kubectl apply -f ./infra/kubernetes/deployments/deployment.yaml
    kubectl apply -f ./infra/kubernetes/services/service.yaml
    ;;
  clear)
    kubectl delete --all configmaps
    kubectl delete --all secrets
    kubectl delete --all deployments
    kubectl delete --all svc
    kubectl delete --all pods
    ;;
  *) echo 'Comando não encontrado!' ;;
esac
