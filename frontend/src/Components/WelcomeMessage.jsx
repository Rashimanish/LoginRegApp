import React from 'react';
import './component.css';

const WelcomeMessage = () => {
    const loggedInUser = JSON.parse(localStorage.getItem('loggedInUser'));

    return (
        <div className='welcomecontainer'>
            <h2 className='welcomemsg'>Welcome, {loggedInUser ? loggedInUser.name : 'User'}!</h2>
        </div>
    );
};

export default WelcomeMessage;