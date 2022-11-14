const endpoint="http://localhost:8080";

async function get(path){
    try{
const response=await fetch(endpoint+path,{
    method:"GET",
    headers:{
        "Content-type":"application/json",
    }
});
return response;
    }catch(error){
        console.log(error);
    }
    return null;
}

async function put(path,body){
    try{
        const response=await fetch(endpoint+path,{
            method:"PUT",
            headers:{
                "Content-type":"application/json",
            },
            body:JSON.stringify(body),
        });
        return response;

    }catch(error){
        console.log(error);
    }return null;
}

async function post(path,body){
    try{
        const response=await fetch(endpoint+path,{
            method:"POST",
            headers:{
                "Content-type":"application/json",
            },
            body:JSON.stringify(body),
        });
        return response;

    }catch(error){
        console.log(error);
    }return null;
}

async function del(path,body){
    try{
        const response=await fetch(endpoint+path,{
            method:"DELETE",
            headers:{
                "Content-type":"application/json",
            },
            body:JSON.stringify(body),
        });
        return response;

    }catch(error){
        console.log(error);
    }return null;
}

export default{
    get,
    post,
    put,
    del
}