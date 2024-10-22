document.addEventListener('DOMContentLoaded', () => {
    fetch('/api/pets')
        .then(response => response.json())
        .then(pets => {
            const petContainer = document.getElementById('pet-container');
            pets.forEach(pet => {
                const petCard = document.createElement('div');
                petCard.className = 'pet-card';
                petCard.innerHTML = `
                    <h3>${pet.name}</h3>
                    <p>Breed: ${pet.breed}</p>
                    <p>Age: ${pet.age}</p>
                    <p>${pet.description}</p>
                `;
                petContainer.appendChild(petCard);
            });
        });
});
