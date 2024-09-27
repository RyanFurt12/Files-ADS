import './App.css'

import { followers } from './assets/followers'

import FollowerCard from './components/FollowerCard/FollowerCard'

function App() {
  return (
    <>
    <div className='container'>
      <h1>Lista de { followers.length } Seguidores - RyanFurt12</h1>
      <div className="cards-area">
        {followers.map((follower) =>{
          return(
            <>
              <FollowerCard
                avatar = {follower.avatar_url}
                name = {follower.login}
                githubLink = {follower.html_url}
              />
            </>
          );
        })}
      </div>
    </div>
    </> 
  )
}

export default App
