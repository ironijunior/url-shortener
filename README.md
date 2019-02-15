# url-shortener

## USEFUL INFORMATION
- current using H2 database
- to run as a Docker Image run the command `docker build -t url-shortener . && docker run -p 8080:8080 -it url-shortener` inside the root directory

## HOW IT WORKS
### [POST] to `/short`
- passing in the body an Json object with the url to short, like:

```json
{
	"url" : "https://github.com/ironijunior/url-shortener"
}
```

- returns the shortened url and its statistics, like:

```json
{
    "id": "1521071681",
    "url": "https://github.com/ironijunior/url-shortener",
    "shortenedUrl": "localhost:8080/1521071681",
    "hits": null,
    "lastHit": null
}
```

- shortened url contains the URL that redirects to the original link

SAMPLE:

![](http://uploaddeimagens.com.br/images/001/844/422/full/POST.PNG?1547935410)

### [GET] to `/{id}`
- redirects to the original url link


SAMPLE:

![](http://uploaddeimagens.com.br/images/001/844/429/full/GET.PNG?1547935524)

### [GET] to `/{id}/stats`
- retrieves the statistics about the shortened url, like

## TODO:
- add an efficient method of url encoding
- transform statistics in another Persistent Object (PO)
- add different statistics
- add more scenarios of tests
- add support to a different Database
