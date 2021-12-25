/*
Using SQL for basic Data Exploration of current Covid 19 death total
The database was provided by Kaggle where it originated from Our World in Data.
This project was inspired by the YouTube channel AlexTheAnalyst, where he pulls a similar data set and explores Covid 19 death and vaccination progress
Skills used: Table Joins, CTE's, Temp Tables, Windows Functions, Aggregate Functions, Creating Views, Converting Data Types
*/

Select *
From Code..Covid_Deaths
Where continent is not null
order by 3,4


-- Select Data that we are going to be starting with

Select Location, date, total_cases, new_cases, total_deaths, population
From Code..Covid_Deaths
Where continent is not null
order by 1,2


-- Total Cases vs Total Deaths: Shows likelihood of dying if you contract covid in your country

Select Location, date, total_cases,total_deaths, (total_deaths/total_cases)*100 as Death_Percentage
From Code..Covid_Deaths
Where location like '%states%'
and continent is not null
order by 1,2


-- Total Cases vs Population: Shows what percentage of population infected with Covid

Select Location, date, Population, total_cases,  (total_cases/population)*100 as Population_Infected_Percentage
From Code..Covid_Deaths
--Where location like '%states%'
order by 1,2


-- Countries with Highest Infection Rate compared to Population

Select Location, Population, MAX(total_cases) as Highest_Infection,  Max((total_cases/population))*100 as Population_Infected_Percentage
From Code..Covid_Deaths
--Where location like '%states%'
Group by Location, Population
order by Population_Infected_Percentage desc


-- Countries with Highest Death Count per Population

Select Location, MAX(cast(Total_deaths as int)) as Total_Death
From Code..Covid_Deaths
--Where location like '%states%'
Where continent is not null
Group by Location
order by Total_Death desc


-- BREAKING THINGS DOWN BY CONTINENT: Showing contintents with the highest death count per population

Select continent, MAX(cast(Total_deaths as int)) as Total_Death
From Code..Covid_Deaths
--Where location like '%states%'
Where continent is not null
Group by continent
order by Total_Death desc


-- GLOBAL NUMBERS

Select SUM(new_cases) as total_cases, SUM(cast(new_deaths as int)) as total_deaths, SUM(cast(new_deaths as int))/SUM(New_Cases)*100 as Death_Percentage
From Code..Covid_Deaths
--Where location like '%states%'
where continent is not null
--Group By date
order by 1,2


-- Total Population vs Vaccinations; Shows Percentage of Population that has recieved at least one Covid Vaccine

Select dea.continent, dea.location, dea.date, dea.population, vac.new_vaccinations
, SUM(CONVERT(int,vac.new_vaccinations)) OVER (Partition by dea.Location Order by dea.location, dea.Date) as Rolling_Vaccinated
--, (Rolling_Vaccinated/population)*100
From Code..Covid_Deaths dea
Join Code..Vaccinations vac
	On dea.location = vac.location
	and dea.date = vac.date
where dea.continent is not null
order by 2,3


-- Using CTE to perform Calculation on Partition By in previous query

With PopvsVac (Continent, Location, Date, Population, New_Vaccinations, Rolling_Vaccinated)
as
(
Select dea.continent, dea.location, dea.date, dea.population, vac.new_vaccinations
, SUM(CONVERT(int,vac.new_vaccinations)) OVER (Partition by dea.Location Order by dea.location, dea.Date) as Rolling_Vaccinated
--, (Rolling_Vaccinated/population)*100
From Code..Covid_Deaths dea
Join Code..Vaccinations vac
	On dea.location = vac.location
	and dea.date = vac.date
where dea.continent is not null
--order by 2,3
)
Select *, (Rolling_Vaccinated/Population)*100
From PopvsVac


-- Using Temp Table to perform Calculation on Partition By in previous query

DROP Table if exists #Population_Vaccinated_Percentage
Create Table #Population_Vaccinated_Percentage
(
Continent nvarchar(255),
Location nvarchar(255),
Date datetime,
Population numeric,
New_vaccinations numeric,
Rolling_Vaccinated numeric
)


Insert into #Population_Vaccinated_Percentage
Select dea.continent, dea.location, dea.date, dea.population, vac.new_vaccinations
, SUM(CONVERT(int,vac.new_vaccinations)) OVER (Partition by dea.Location Order by dea.location, dea.Date) as Rolling_Vaccinated
--, (Rolling_Vaccinated/population)*100
From Code..Covid_Deaths dea
Join Code..Vaccinations vac
	On dea.location = vac.location
	and dea.date = vac.date
--where dea.continent is not null
--order by 2,3


Select *, (Rolling_Vaccinated/Population)*100
From #Population_Vaccinated_Percentage


-- Creating View to store data for later visualizations

Create View Population_Vaccinated_Percentage as
Select dea.continent, dea.location, dea.date, dea.population, vac.new_vaccinations
, SUM(CONVERT(int,vac.new_vaccinations)) OVER (Partition by dea.Location Order by dea.location, dea.Date) as Rolling_Vaccinated
--, (Rolling_Vaccinated/population)*100
From Code..Covid_Deaths dea
Join Code..Vaccinations vac
	On dea.location = vac.location
	and dea.date = vac.date
where dea.continent is not null
