import React, {useState, useEffect} from "react";
import Post from "../Post/Post";
import CssBaseline from '@mui/material/CssBaseline';
import Box from '@mui/material/Box';
import Container from '@mui/material/Container';
import { makeStyles } from "@mui/styles";

const useStyles = makeStyles((theme) => ({
    container: {
        display: "flex",
        flexWrap: "wrap",
        justifyContent: "center",
        alignItems: "center",
        backgroundColor: '#cfe8fc',
        height: '93vh',
    }
}))

function Home(){
    const [error, setError] = useState(null);
    const [isLoaded, setIsLoaded] = useState(false);
    const [postList, setPostList] = useState([]);
    const classes = useStyles();

    useEffect(() => {
       // const userId = 1;
       // fetch(`/Post/getAllPosts?UserId=${userId}`)

        fetch(`/Post/getAllPosts`)
        .then(res => res.json())
        .then(
            (result) => {
                setIsLoaded(true);
                setPostList(result);
            },
            (error) => {
                setIsLoaded(true);
                setError(error);  
                console.log(error);
            }
        )
    }, [])

    if(error){
        return <div> Error !!! </div>
    } else if(!isLoaded){
        return <div> Loading... </div>
    } else {
        return(
            <Container fixed className={classes.container}>
                {postList.map(post => (
                    <Post title={post.title} text={post.text}></Post>
                ))}
            </Container>
        );
    }
}

export default Home;