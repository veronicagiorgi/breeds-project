const url = 'http://localhost:8080/api/breeds';
const urlInput = 'http://localhost:8080/api/breeds?search=';

const contentElement = document.getElementById('breed');
const nameInput = document.getElementById('input');
const clickBtn = document.getElementById('clickBreed');

//PRENDO UN BREED
const renderBreed = (breed) =>{
  let card = `<div class="card col-12 col-md-6 col-lg-4 p-0 h-100 my-3">
  <div>
    <img src="${breed.imageUrl}" class="card-img-top img-thumbnail" alt="...">
  </div>
  <div class="card-body ">
    <h5 class="card-title">${breed.name}</h5>
    <p class="card-text">${breed.description}</p>
    <div>
      <p> ${font(breed)}
      </p>
    </div>
  </div>
  <div class="card-footer d-flex justify-content-between">
      <div>
      <i class="fa-solid fa-ruler-combined"></i>${breed.size}
      </div> 
      <div>
        <i class="fa-solid fa-heart-pulse"></i>${breed.minLifeSpan} - ${breed.maxLifeSpan}
      </div>
  </div> 
</div>`;
return card;
};

//PRENDO LA LISTA DI BREED
const renderBreedList = (data) => {
  let content = ' <div class="row">';
  data.forEach((element) => {
    content += renderBreed(element);
  });
  content += '</div>';
  contentElement.innerHTML = content;
  };


//GET ALL BREEDS

const getBreeds = async () => {
  try {
    const response = await fetch(url);
    console.log(response);
    if(response.ok){
      const data = await response.json();
      console.log(data);
      renderBreedList(data);
    } else {
        console.log(response.status);
    }
  } catch (error){
    console.log(error);
  }
};

//DELETE ONE DOG
const deleteById = async (target) => {
  console.log(target.dataset.deleteid);
  const response = await fetch(url + target.dataset.deleteid, {
    method: 'DELETE',
  });
  if (response.ok) {
    getBreeds();
  }
};
///// non applicabile in html sono in ritardo..


const getBreedByInputName = async () => {
  const breedName = nameInput.value;
  try {
    const response = await fetch(urlInput+breedName);
    console.log(response);
    if(response.ok){ 
      const data = await response.json();
      console.log(data);
      let div = '';
      data.forEach(breed => {
        div += `<div class="card col-12 col-md-6 col-lg-4 p-0 h-100 my-3">
        <div>
          <img src="${breed.imageUrl}" class="card-img-top img-thumbnail" alt="...">
        </div>
        <div class="card-body ">
          <h5 class="card-title">${breed.name}</h5>
          <p class="card-text">${breed.description}</p>
          <div>
            <p>Trainability ${breed.trainability}
            </p>
          </div>
        </div>
        <div class="card-footer d-flex justify-content-between">
            <div>
            <i class="fa-solid fa-ruler-combined"></i>${breed.size}
            </div> 
            <div>
              <i class="fa-solid fa-heart-pulse"></i>${breed.minLifeSpan} - ${breed.maxLifeSpan}
            </div>
        </div> 
      </div>`
      });
      contentElement.innerHTML = div;
    } else {
        console.log(response.status);
    }
  } catch (error){
    console.log(error);
  }
};

//funzione number--> font
function font(element) {
  let card =  `<span>Trainability </span><span>`
  let i = 0;
  for (i=0; i<element.trainability; i++) {
    card += `<i class="fa-solid fa-star"></i>`;
  }
  for (j = element.trainability; j <= 4; j++) {
    card += `<i class="fa-regular fa-star"></i>`;
  }
  card += `</span>`
  return card;
};


getBreeds(); 
clickBtn.addEventListener('click', (event)=>{
  event.preventDefault();
  getBreedByInputName();
})




  
  