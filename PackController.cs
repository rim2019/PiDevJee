using Data;
using Domain.entities;
using Service;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using WebApp.Models;

namespace WebApp.Controllers
{
    public class PackController : Controller
    {
        PackService PS;
        ProduitService ProduitS;
        Context db = new Context();

        public PackController()
        {
            PS = new PackService();
            ProduitS = new ProduitService();
        }

        // GET: Pack
        [HttpGet]
        public ActionResult Index(PackModels PM)
        {

            var Entreprise = ProduitS.GetAll();

            ViewBag.EntrepriseList = new SelectList(Entreprise, "IdProduit", "Name");

            return View(new PackModels
            {
                IDPack = new Pack(),
                ListProduits = ProduitS.GetAll()
            });
        }

        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult CreatePack(Pack PM, Produit PP, PackModels pmm)
        {
            if (ModelState.IsValid)
            {
                using (Context conn = new Context())
                {
                    Produit p = new Produit();

                    var x = pmm.IdProduitsFk;
                    double prix = 0;
                    foreach (var it in x)
                    {
                        foreach (var item in conn.Product)
                        {
                            if (item.IdProduit == it)
                            {
                                p = item;
                                prix = prix + item.Prix;
                            }
                        }

                        pmm.IDPack.PrixTotaleProduitorig = prix;
                        pmm.IDPack.NouveauPrixTotaleProduit = prix - ((prix * pmm.IDPack.PourcentageDeReduction) / 100);
                        pmm.IDPack.Produits.Add(p);
                        conn.packs.Add(pmm.IDPack);
                    }
                    conn.SaveChanges();

                }
                
                return RedirectToAction("Index", "Pack");
            }
            else
            {
                return RedirectToAction("Index", "Offre");

            }
        }


        public ActionResult Affichage()
        {
            return View(PS.GetAll());

        }


        // GET: Product/Delete/5
        public ActionResult Delete(int id)
        {

            return View(PS.GetById(id));
        }

        // POST: Product/Delete/5
        [HttpPost]
        public ActionResult Delete(int id, Pack p)
        {
            p = PS.GetById(id);
            PS.Delete(p);
            PS.Commit();
            return RedirectToAction("Affichage");

        }
        
        // GET: Product/Details/5
        public ActionResult Details(int id)
        {PackModels pm = new PackModels();
            var x = PS.GetById(id);
            pm.ListProduits = x.Produits;
            return View(pm);
        }









    }
}




    
