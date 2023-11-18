import http from "http"

const server = http.createServer((req, res) => {
    const recievedData = []
    if(req.url === '/log'){
        req.on('data',(chunk) => {
            recievedData.push(chunk)
        }).on('end',() => {
            console.log(recievedData.toString())
        })
        res.end("success")
    }
})

server.listen(2000,() => console.log("Server Listening"))