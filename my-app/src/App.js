import React, { useState } from 'react';
import { BrowserRouter as Router, Route, Routes, Link } from 'react-router-dom';
import {AppBar,Toolbar, Typography,Container,IconButton,Badge,Box,TextField, Stack,Button} from '@mui/material';
import MenuIcon from '@mui/icons-material/Menu';
import MailIcon from '@mui/icons-material/Mail';
import FaceIcon from '@mui/icons-material/Face';
import ImageList from '@mui/material/ImageList';
import ImageListItem from '@mui/material/ImageListItem';
import ImageListItemBar from '@mui/material/ImageListItemBar';
import ListSubheader from '@mui/material/ListSubheader';
import InfoIcon from '@mui/icons-material/Info';
import Checkbox from '@mui/material/Checkbox';
import FavoriteBorder from '@mui/icons-material/FavoriteBorder';
import Favorite from '@mui/icons-material/Favorite';
import BookmarkBorderIcon from '@mui/icons-material/BookmarkBorder';
import BookmarkIcon from '@mui/icons-material/Bookmark';
import SvgIcon from '@mui/material/SvgIcon';
import FavoritesPage from './FavoritesPage';
import './App.css';
import ProfilePage from './ProfilePage';

  const itemData = [
    {
      img: 'http://www.pixelstalk.net/wp-content/uploads/2016/07/Peaceful-Desktop-Backgrounds.jpeg',
      title: 'peaceful background',
      author: 'pixelstalk',
      rows: 3,
      cols: 3,
      featured: true,
    },
    {
      img: 'https://tse1.mm.bing.net/th?id=OIP.gCvQ1vmPVJmrq1nnzM3ZHQHaEo&pid=Api&P=0&h=180',
      title: 'background image',
      author: 'wallpaper',
    },
    {
      img: 'https://wallpapercave.com/wp/wp2858563.jpg',
      title: 'Beautiful Nature Background',
      author: 'wallpapercarve',
    },
    {
      img: 'https://cdn.pixabay.com/photo/2015/09/09/17/42/coffee-932103_960_720.jpg',
      title: 'Coffee',
      author: '@nolanissac',
      cols: 2,
    },
    {
      img: 'https://images.unsplash.com/photo-1533827432537-70133748f5c8',
      title: 'Hats',
      author: '@hjrc33',
      cols: 2,
    },
    {
      img: 'https://images.unsplash.com/photo-1558642452-9d2a7deb7f62',
      title: 'Honey',
      author: '@arwinneil',
      rows: 2,
      cols: 2,
      featured: true,
    },
    {
      img: 'https://ehabphotography.com/wp-content/uploads/2015/11/450441641.jpg',
      title: 'Basketball',
      author: '@tjdragotta',
    },
    {
      img: 'https://images.unsplash.com/photo-1518756131217-31eb79b20e8f',
      title: 'Fern',
      author: '@katie_wasserman',
    },
    {
      img: 'https://images.unsplash.com/photo-1597645587822-e99fa5d45d25',
      title: 'Mushrooms',
      author: '@silverdalex',
      rows: 2,
      cols: 2,
    },
    {
      img: 'http://1.bp.blogspot.com/-_pw0Zt399KU/UK5v8tvP4GI/AAAAAAAABBw/_FGK-GYSYoo/s1600/27413-1600x1200-dolphins-with-rainbow.jpg',
      title: 'Dolphins',
      author: 'namawallpapers',
    },
    {
      img: 'https://images.unsplash.com/photo-1471357674240-e1a485acb3e1',
      title: 'Sea star',
      author: '@peterlaster',
    },
    {
      img: 'https://images.unsplash.com/photo-1589118949245-7d38baf380d6',
      title: 'Bike',
      author: '@southside_customs',
      cols: 2,
    },
  ];
  
  function HomeIcon(props) {
    return (
      <SvgIcon {...props}>
        <path d="M10 20v-6h4v6h5v-8h3L12 3 2 12h3v8z" />
      </SvgIcon>
    );
  }
  
  function App() {
    const [searchQuery, setSearchQuery] = useState('');
    const [favorites, setFavorites] = useState([]);
    const [bookmarks, setBookmarks] = useState([]);
  
    const handleSearchChange = (event) => {
      setSearchQuery(event.target.value);
    };
  
    const handleFavoriteToggle = (img) => {
      setFavorites((prevFavorites) =>
        prevFavorites.includes(img)
          ? prevFavorites.filter((favorite) => favorite !== img)
          : [...prevFavorites, img]
      );
    };
  
    const handleBookmarkToggle = (img) => {
      setBookmarks((prevBookmarks) =>
        prevBookmarks.includes(img)
          ? prevBookmarks.filter((bookmark) => bookmark !== img)
          : [...prevBookmarks, img]
      );
    };
  
    const filteredItems = itemData.filter((item) =>
      item.title.toLowerCase().includes(searchQuery.toLowerCase())
    );
  

  return (
    <Router>
      <div className="App">
        <AppBar position="static">
          <Toolbar>
            <IconButton edge="start" color="inherit" aria-label="menu">
              <MenuIcon />
            </IconButton>
            <Badge color="secondary" variant="dot">
              <MailIcon />
            </Badge>
            <IconButton color="inherit" component={Link} to="/profile">
              <FaceIcon />
</IconButton>
            <Typography variant="h6" style={{ flexGrow: 1 }}>
              My Images
            </Typography>
            <Box
              component="form"
              sx={{
                '& > :not(style)': { m: 1, width: '25ch' },
              }}
              noValidate
              autoComplete="off"
            >
              <TextField id="outlined-basic" label="Search" variant="outlined" value={searchQuery} onChange={handleSearchChange} />
            </Box>
            <Stack direction="row" spacing={1}>
              <HomeIcon />
            </Stack>
          </Toolbar>
        </AppBar>
        <Container style={{ marginTop: '20px' }}>
          <Routes>
            <Route
              path="/"
              element={
                <>
                  <Typography variant="h3" component="h1" gutterBottom>
                    Welcome to My Images
                  </Typography>
                  <ImageList sx={{ width: 500, height: 450 }}>
                    <ImageListItem key="Subheader" cols={2}>
                      <ListSubheader component="div">Background Images</ListSubheader>
                    </ImageListItem>
                    {filteredItems.map((item) => (
                      <ImageListItem key={item.img}>
                        <img
                          srcSet={`${item.img}?w=248&fit=crop&auto=format&dpr=2 2x`}
                          src={`${item.img}?w=248&fit=crop&auto=format`}
                          alt={item.title}
                          loading="lazy"
                        />
                        <div>
                          <Checkbox
                            icon={<FavoriteBorder />}
                            checkedIcon={<Favorite />}
                            checked={favorites.includes(item.img)}
                            onChange={() => handleFavoriteToggle(item.img)}
                          />
                          <Checkbox
                            icon={<BookmarkBorderIcon />}
                            checkedIcon={<BookmarkIcon />}
                            checked={bookmarks.includes(item.img)}
                            onChange={() => handleBookmarkToggle(item.img)}
                          />
                        </div>
                        <ImageListItemBar
                          title={item.title}
                          subtitle={item.author}
                          actionIcon={
                            <IconButton
                              sx={{ color: 'rgba(255, 255, 255, 0.54)' }}
                              aria-label={`info about ${item.title}`}
                            >
                              <InfoIcon />
                            </IconButton>
                          }
                        />
                      </ImageListItem>
                    ))}
                  </ImageList>
                  <Button variant="contained" color="primary" component={Link} to="/favorites">
                    View Favorites and Bookmark
                  </Button>
                </>
              }
            />
            <Route
              path="/favorites"
              element={<FavoritesPage favorites={favorites} bookmarks={bookmarks} />}
            />
            <Route path="/profile" element={<ProfilePage />} />
          </Routes>
        </Container>
      </div>
    </Router>
  );
}

export default App;
