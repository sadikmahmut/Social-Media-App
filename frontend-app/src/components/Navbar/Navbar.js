import React from "react";
import {Link} from "react-router-dom";
import AppBar from '@mui/material/AppBar';
import Box from '@mui/material/Box';
import Toolbar from '@mui/material/Toolbar';
import Typography from '@mui/material/Typography';
import Button from '@mui/material/Button';
import IconButton from '@mui/material/IconButton';
import MenuIcon from '@mui/icons-material/Menu';
import { makeStyles } from "@mui/styles";

const useStyles = makeStyles((theme) => ({
    title: {
        flexGrow: 1,
        textAlign: "left"
    },
    link: {
        textDecoration: "none",
        boxShadow: "none",
        color: "white"
    }
}))

function Navbar(){
    let UserId = 5;
    const classes = useStyles();

    return(
        <div className="container">
            <Box sx={{ flexGrow: 1 }}>
                <AppBar position="static">
                    <Toolbar>
                    <IconButton
                        size="large"
                        edge="start"
                        color="inherit"
                        aria-label="menu"
                        sx={{ mr: 2 }}
                    >
                        <MenuIcon />
                    </IconButton>
                    <Typography variant="h6" component="div" sx={{ flexGrow: 1 }} className={classes.title}>
                        Social Media App
                    </Typography>
                    <Button color="inherit">
                        <Link className={classes.link} to="/">Home</Link>
                    </Button>
                    <Button color="inherit">
                        <Link className={classes.link} to={{pathname : '/User/getUser/' + UserId}}>User</Link>
                    </Button>
                    <Button color="inherit">Login</Button>
                    </Toolbar>
                </AppBar>
            </Box>
        </div>
    )
}

export default Navbar;