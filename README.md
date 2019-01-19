# url-shortener

## USEFUL INFORMATION
- current using an H2 database[
- to run as a Docker Image run the command `docker build .` inside the root directory

## HOW IT WORKS
### [POST] to `/short`
- passing in the body an url to short
- returns the shortened url and its statistics
	- shortened url contains an ID that redirects to the original link

### [GET] to `/{id}`
- returns the original url link and its statistics


## TODO:
- add an efficient method of url encoding
- transform statistics in another Persistent Object (PO)
- add different statistics
- add more scenarios of tests
- add support to a different Database
