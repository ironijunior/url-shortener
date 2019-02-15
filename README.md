# url-shortener

## USEFUL INFORMATION
- current using H2 database
- to run as a Docker Image, execute in root directory:

```sh
docker build -t url-shortener . && docker run -p 8080:8080 -it url-shortener
```

## HOW IT WORKS
### [POST] to `/short`
- passing in the body a Json object with the url to short, like:

```json
{
	"url" : "https://github.com/ironijunior/url-shortener"
}
```

SAMPLE:

![](https://uploaddeimagens.com.br/images/001/901/343/full/post.PNG?1550254082)

- returns a Json object containing the shortened url and its statistics, like:

```json
{
    "id": "1521071681",
    "url": "https://github.com/ironijunior/url-shortener",
    "shortenedUrl": "localhost:8080/1521071681",
    "hits": null,
    "lastHit": null
}
```
SAMPLE:

![](https://uploaddeimagens.com.br/images/001/901/353/full/post_result.PNG?1550254208)


### [GET] to `/{id}`
- redirects to the original url link


### [GET] to `/{id}/stats`
- retrieves a Json object containing the statistics about the shortened url, like:

```json
{
    "id": "573319227",
    "url": "https://github.com/ironijunior/url-shortener",
    "shortenedUrl": "localhost:8080/573319227",
    "hits": 3,
    "lastHit": "2019-02-15T18:02:01.840+0000"
}
```

SAMPLE:

![](https://uploaddeimagens.com.br/images/001/901/375/full/get_stats.PNG?1550254400)
![](https://uploaddeimagens.com.br/images/001/901/377/full/stats_result.PNG?1550254424)

## TODO:
- add an efficient method of url encoding
- transform statistics in another Persistent Object (PO)
- add different statistics
- add more scenarios of tests
- add support to a different Database
