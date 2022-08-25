import React from 'react'

const form = () => {
  return (
    <div>
        <form>
  <label>
    Nom :
    <input type="text" name="name" />
  </label>
  <input type="submit" value="Envoyer" />
</form>
    </div>
  )
}

export default form