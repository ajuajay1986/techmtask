# School and Student Service
## API methods

### Create school

```bash
curl -X POST --header 'Content-Type: application/json' --header 'Accept: */*' -d '{ \ 
   "name": "DAV", \  
 }' 'http://localhost:8181/api/schools'
```

### Get a school details

```bash
curl -X GET --header 'Accept: application/json' 'http://localhost:8181/api/schools/2'
```

### Create studet

```bash
curl -X POST --header 'Content-Type: application/json' --header 'Accept: */*' -d '{ \ 
   "name": "Ajay", \
   "schoolId": "1", \  
 }' 'http://localhost:8080/api/students'
```

### Get a studet details

```bash
curl -X GET --header 'Accept: application/json' 'http://localhost:8080/api/students/1'
```
