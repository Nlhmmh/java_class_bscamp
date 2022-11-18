const domain = "http://localhost:8090"

async function get(path){
    try {
        const resp = await fetch(
            domain + path,
            {
                method: "GET",
            }
        );
    
        return resp;
    } catch (error) {
        console.log(error);
    }
    
    return null;
}

async function post(path, body){
    const resp = await fetch(
        domain + path,
        {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(body)
        }
    );

    return resp;
}

async function put(path, body){
    const resp = await fetch(
        domain + path,
        {
            method: "PUT",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(body)
        }
    );

    return resp;
}

async function deleteMethod(path, body){
    const resp = await fetch(
        domain + path,
        {
            method: "DELETE",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(body)
        }
    );

    return resp;
}

export default {
    get, post, put, deleteMethod
};