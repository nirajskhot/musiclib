const artist_list = [];
const album_list = [];
let track_list = [];

const artist_cache = {};
const album_cache = {};


const load_all_tracks = async () => {
    const response = await fetch('http://localhost:9999/list/all', {
        method: 'GET',
        headers: {
            'Content-Type': 'application/json'
        }
    });
    const res = await response.json();
    if(res["statuscode"]=200){
        track_list = res["trackList"];
        show_track_list();
    }else{
        show_error_message(res["message"]);
    }
};

const load_artist_tracks = async () => {
    console.log("Testing")
    let input1 = document.getElementById("input1").value;
    let input2 = document.getElementById("input2").value;
    let query = input1 + "_" + input2;
};

const show_track_list = async () => {
    let content = "<table border=\"1\"><tr><th>Title</th><th>Artist</th><th>Album</th><th>Link</th></tr>";
    for(let item of track_list){
        content += "<tr><td>" + item["title"] + "</td><td>" + item["artist"] + "</td><td>" + item["album"] + "</td><td><a href=\"" + item["link"] +  "\">Link</a></td></tr>"
    }
    content +="</table>"
    document.getElementById("resbox").innerHTML = content;
};

const show_error_message = (message) => {
    document.getElementById("resbox").innerHTML = message;
};