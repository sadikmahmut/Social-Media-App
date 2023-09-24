import React from "react";
import {useParams} from "react-router-dom";

function User(){
   const {UserId} = useParams(); 
   return(
    <div>
        User !! {UserId}
    </div>
   )
}

export default User;