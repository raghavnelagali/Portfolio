
const apiKey ="ddb82998d927134cdb3f3053de8d8fe8";
const apiUrl ="https://api.openweathermap.org/data/2.5/weather?units=metric&q=";

const seacrhBox = document.querySelector(".search input");
const seacrhBtn = document.querySelector(".search button");
const weatherIcon = document.querySelector(".weather-icon");

async function checkWeather(city){
    const response = await fetch (apiUrl + city + `&appid=${apiKey}`);
    var data = await response.json();

    console.log(data);

    document.querySelector(".city").innerHTML=data.name;
    document.querySelector(".temp").innerHTML=Math.round(data.main.temp) + "°C";
    document.querySelector(".humidity").innerHTML=data.main.humidity + "%";
    document.querySelector(".wind").innerHTML=data.wind.speed + "Km/h";

    if(data.weather[0].main == "Clouds"){
        weatherIcon.src = "images/clouds.png";
    }
    if(data.weather[0].main == "Clear"){
        weatherIcon.src = "images/clear.png";
    }
    if(data.weather[0].main == "Rain"){
        weatherIcon.src = "images/rain.png";
    }
    if(data.weather[0].main == "Drizzle"){
        weatherIcon.src = "images/drizzle.png";
    }
    if(data.weather[0].main == "Mist"){
        weatherIcon.src = "images/mist.png";
    }

}
seacrhBtn.addEventListener("click",()=>{
    checkWeather(seacrhBox.value);
})
 
seacrhBox.addEventListener("keypress", function(event){
    if (event.key === "Enter"){
        checkWeather(seacrhBox.value);
        document.getElementById("seacrhBtn").click();
    }
})


