const localDomain = "http://localhost:8080";

async function get(path) {
    try {
        const resp = await fetch(localDomain + path, {
            method: "GET",
        });
        return resp;
    } catch (error) {
        console.log(error);
    }
    return null;
}

async function post(path,body) {
    try {
        const resp = await fetch(localDomain + path, {
            method: "POST",
            headers: {
                "Content-Type" : "application/json",
            },
            body: JSON.stringify(body),
        });
        return resp;
    } catch (error) {
        console.log(error);
    }
    return null;
}

async function put(path,body) {
    try {
        const resp = await fetch(localDomain + path, {
            method: "PUT",
            headers: {
                "Content-Type" : "application/json",
            },
            body: JSON.stringify(body),
        });
        return resp;
    } catch (error) {
        console.log(error);
    }
    return null;
}

async function del(path,body) {
    try {
        const resp = await fetch(localDomain + path, {
            method: "DELETE",
        });
        return resp;
    } catch (error) {
        console.log(error);
    }
    return null;
}

export default {
    get,
    post,
    put,
    del
}